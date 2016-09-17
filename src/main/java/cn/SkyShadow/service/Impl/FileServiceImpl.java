package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.excution.Execution;
import cn.SkyShadow.dto.factory.ExcutionFactory;
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
    public Execution UpdateVoice(voice voice) {
        return ExcutionFactory.GetExcutionByResultCode(voiceMapper.insert(voice));
    }

    @Override
    public Execution UpdateVideo(video video) {
        return ExcutionFactory.GetExcutionByResultCode(videoMapper.insert(video));
    }

    @Override
    public Execution UpdateImage(imagine imagine) {
        return ExcutionFactory.GetExcutionByResultCode(imagineMapper.insertSelective(imagine));
    }

    @Override
    public Execution UpdateExpr(expr expr) {
        return ExcutionFactory.GetExcutionByResultCode(exprMapper.insert(expr));
    }

    @Override
    public Execution UpdateFile(file file) {
        return ExcutionFactory.GetExcutionByResultCode(fileMapper.insert(file));
    }

    @Override
    public Execution UpdateFileGroup(filegroup filegroup) {
        return ExcutionFactory.GetExcutionByResultCode(filegroupMapper.insert(filegroup));
    }

    @Override
    public FileList GetFileList(Long organizationID) {
        return organizationMapper.GetFileList(organizationID);
    }

    @Override
    public Execution DeleteFile(Long fileId) {
        return ExcutionFactory.GetExcutionByResultCode(fileMapper.deleteByPrimaryKey(fileId));
    }

    @Override
    public Execution DeleteFileGroup(Long filegroupId) {
        return ExcutionFactory.GetExcutionByResultCode(filegroupMapper.deleteByPrimaryKey(filegroupId));
    }

    @Override
    public Execution UpdateFileToOrg(Long orgId, Long fileId) {
        return ExcutionFactory.GetExcutionByResultCode(fileMapper.AddFileToOrg(orgId,fileId));
    }

    @Override
    public Execution RemoveFileFromOrg(Long orgId, Long fileId) {
        return ExcutionFactory.GetExcutionByResultCode(fileMapper.RemoveFileFromOrg(orgId,fileId));
    }

    @Override
    public Execution UpdateFileGroupToOrg(Long orgId, Long fileGroupId) {
        return ExcutionFactory.GetExcutionByResultCode(fileMapper.AddFileToOrg(orgId,fileGroupId));
    }

    @Override
    public Execution RemoveFileGroupFromOrg(Long orgId, Long fileGroupId) {
        return ExcutionFactory.GetExcutionByResultCode(fileMapper.RemoveFileFromOrg(orgId, fileGroupId));
    }
}
