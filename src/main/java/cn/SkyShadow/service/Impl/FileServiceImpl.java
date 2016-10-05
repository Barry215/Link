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

import java.util.List;

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
        return null;
    }

    @Override
    public BaseExecution UpdateVideo(Video video) {
        return null;
    }

    @Override
    public BaseExecution UpdateImage(Imagine imagine) {
        return null;
    }

    @Override
    public BaseExecution UpdateImage(List<Imagine> imagines) {
        return null;
    }

    @Override
    public BaseExecution UpdateExpr(Expr expr) {
        return null;
    }

    @Override
    public BaseExecution UpdateFile(File file) {
        return null;
    }

    @Override
    public BaseExecution UpdateFile(List<File> files) {
        return null;
    }

    @Override
    public BaseExecution UpdateFileGroup(FileGroup fileGroup) {
        return null;
    }
}
