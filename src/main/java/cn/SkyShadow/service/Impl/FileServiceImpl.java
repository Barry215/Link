package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.dto.file.FileList;
import cn.SkyShadow.model.*;
import cn.SkyShadow.dao.*;
import cn.SkyShadow.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文件管理器
 * Created by Richard on 16/9/13.
 */
@Transactional
@Service
public class FileServiceImpl implements FileService {
    private final VoiceMapper VoiceMapper;
    private final VideoMapper VideoMapper;
    private final ImagineMapper ImagineMapper;
    private final FileMapper FileMapper;
    private final FileGroupMapper FileGroupMapper;
    private final ExprMapper ExprMapper;
    private final OrganizationMapper OrganizationMapper;
    @Autowired(required = false)
    public FileServiceImpl(VoiceMapper VoiceMapper, VideoMapper VideoMapper, ImagineMapper ImagineMapper, FileMapper FileMapper, FileGroupMapper FileGroupMapper, ExprMapper ExprMapper, OrganizationMapper OrganizationMapper) {
        this.VoiceMapper = VoiceMapper;
        this.VideoMapper = VideoMapper;
        this.ImagineMapper = ImagineMapper;
        this.FileMapper = FileMapper;
        this.FileGroupMapper = FileGroupMapper;
        this.ExprMapper = ExprMapper;
        this.OrganizationMapper = OrganizationMapper;
    }

    @Override
    public BaseExecution UpdateVoice(Voice voice) {
        return ExecutionFactory.getExecutionByResultCode(VoiceMapper.insert(voice));
    }

    @Override
    public BaseExecution UpdateVideo(Video video) {
        return ExecutionFactory.getExecutionByResultCode(VideoMapper.insert(video));
    }

    @Override
    public BaseExecution UpdateImage(Imagine imagine) {
        return ExecutionFactory.getExecutionByResultCode(ImagineMapper.insertSelective(imagine));
    }

    @Override
    public BaseExecution UpdateExpr(Expr expr) {
        return ExecutionFactory.getExecutionByResultCode(ExprMapper.insert(expr));
    }

    @Override
    public BaseExecution UpdateFile(File file) {
        return ExecutionFactory.getExecutionByResultCode(FileMapper.insert(file));
    }

    @Override
    public BaseExecution UpdateFileGroup(FileGroup fileGroup) {
        return ExecutionFactory.getExecutionByResultCode(FileGroupMapper.insert(fileGroup));
    }

    @Override
    public FileList GetFileList(Long organizationID) {
        return OrganizationMapper.GetFileList(organizationID);
    }

    @Override
    public BaseExecution DeleteFile(Long fileId) {
        return ExecutionFactory.getExecutionByResultCode(FileMapper.deleteByPrimaryKey(fileId));
    }

    @Override
    public BaseExecution DeleteFileGroup(Long fileGroupId) {
        return ExecutionFactory.getExecutionByResultCode(FileGroupMapper.deleteByPrimaryKey(fileGroupId));
    }

    @Override
    public BaseExecution UpdateFileToOrg(Long orgId, Long fileId) {
        return ExecutionFactory.getExecutionByResultCode(FileMapper.AddFileToOrg(orgId,fileId));
    }

    @Override
    public BaseExecution RemoveFileFromOrg(Long orgId, Long fileId) {
        return ExecutionFactory.getExecutionByResultCode(FileMapper.RemoveFileFromOrg(orgId,fileId));
    }

    @Override
    public BaseExecution UpdateFileGroupToOrg(Long orgId, Long fileGroupId) {
        return ExecutionFactory.getExecutionByResultCode(FileMapper.AddFileToOrg(orgId,fileGroupId));
    }

    @Override
    public BaseExecution RemoveFileGroupFromOrg(Long orgId, Long fileGroupId) {
        return ExecutionFactory.getExecutionByResultCode(FileMapper.RemoveFileFromOrg(orgId, fileGroupId));
    }
}
