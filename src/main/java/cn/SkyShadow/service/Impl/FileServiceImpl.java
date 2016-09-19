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
    private final voiceMapper voiceMapper;
    private final videoMapper videoMapper;
    private final imagineMapper imagineMapper;
    private final fileMapper fileMapper;
    private final filegroupMapper filegroupMapper;
    private final exprMapper exprMapper;
    private final organizationMapper organizationMapper;
    @Autowired(required = false)
    public FileServiceImpl(cn.SkyShadow.dao.voiceMapper voiceMapper, cn.SkyShadow.dao.videoMapper videoMapper, cn.SkyShadow.dao.imagineMapper imagineMapper, cn.SkyShadow.dao.fileMapper fileMapper, cn.SkyShadow.dao.filegroupMapper filegroupMapper, cn.SkyShadow.dao.exprMapper exprMapper, organizationMapper organizationMapper) {
        this.voiceMapper = voiceMapper;
        this.videoMapper = videoMapper;
        this.imagineMapper = imagineMapper;
        this.fileMapper = fileMapper;
        this.filegroupMapper = filegroupMapper;
        this.exprMapper = exprMapper;
        this.organizationMapper = organizationMapper;
    }

    @Override
    public BaseExecution UpdateVoice(voice voice) {
        return ExecutionFactory.getExecutionByResultCode(voiceMapper.insert(voice));
    }

    @Override
    public BaseExecution UpdateVideo(video video) {
        return ExecutionFactory.getExecutionByResultCode(videoMapper.insert(video));
    }

    @Override
    public BaseExecution UpdateImage(imagine imagine) {
        return ExecutionFactory.getExecutionByResultCode(imagineMapper.insertSelective(imagine));
    }

    @Override
    public BaseExecution UpdateExpr(expr expr) {
        return ExecutionFactory.getExecutionByResultCode(exprMapper.insert(expr));
    }

    @Override
    public BaseExecution UpdateFile(file file) {
        return ExecutionFactory.getExecutionByResultCode(fileMapper.insert(file));
    }

    @Override
    public BaseExecution UpdateFileGroup(filegroup filegroup) {
        return ExecutionFactory.getExecutionByResultCode(filegroupMapper.insert(filegroup));
    }

    @Override
    public FileList GetFileList(Long organizationID) {
        return organizationMapper.GetFileList(organizationID);
    }

    @Override
    public BaseExecution DeleteFile(Long fileId) {
        return ExecutionFactory.getExecutionByResultCode(fileMapper.deleteByPrimaryKey(fileId));
    }

    @Override
    public BaseExecution DeleteFileGroup(Long filegroupId) {
        return ExecutionFactory.getExecutionByResultCode(filegroupMapper.deleteByPrimaryKey(filegroupId));
    }

    @Override
    public BaseExecution UpdateFileToOrg(Long orgId, Long fileId) {
        return ExecutionFactory.getExecutionByResultCode(fileMapper.AddFileToOrg(orgId,fileId));
    }

    @Override
    public BaseExecution RemoveFileFromOrg(Long orgId, Long fileId) {
        return ExecutionFactory.getExecutionByResultCode(fileMapper.RemoveFileFromOrg(orgId,fileId));
    }

    @Override
    public BaseExecution UpdateFileGroupToOrg(Long orgId, Long fileGroupId) {
        return ExecutionFactory.getExecutionByResultCode(fileMapper.AddFileToOrg(orgId,fileGroupId));
    }

    @Override
    public BaseExecution RemoveFileGroupFromOrg(Long orgId, Long fileGroupId) {
        return ExecutionFactory.getExecutionByResultCode(fileMapper.RemoveFileFromOrg(orgId, fileGroupId));
    }
}
