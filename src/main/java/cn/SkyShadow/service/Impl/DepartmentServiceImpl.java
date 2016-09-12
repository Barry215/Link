package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.dto.file.FileList;
import cn.SkyShadow.model.*;
import cn.SkyShadow.service.DepartmentService;

/**
 * Created by RichardW on 9/12/2016.
 */
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public Excution CreateDepartment(organization o, organization father) {
        return null;
    }

    @Override
    public Excution MakeAdmin(user user, organization o) {
        return null;
    }

    @Override
    public Excution MakeAdminCallback(Receipt r) {
        return null;
    }

    @Override
    public Excution MakeAdmin(Long ApplyId) {
        return null;
    }

    @Override
    public Excution DeliverDepartmentCreator(Apply a) {
        return null;
    }

    @Override
    public Excution RollBackDeliverDepartmentCreator(Long applyId) {
        return null;
    }

    @Override
    public Excution DeliverDepartmentCreatorCallback(Receipt r) {
        return null;
    }

    @Override
    public Excution DeleteDepartment(Long DepId) {
        return null;
    }

    @Override
    public Excution ModifyDepart(organization o) {
        return null;
    }

    @Override
    public Excution UpdateFile(file file) {
        return null;
    }

    @Override
    public Excution UpdateFileGroup(filegroup filegroup) {
        return null;
    }

    @Override
    public FileList GetFileList(organization organization) {
        return null;
    }

    @Override
    public Excution DeleteFile(Long fileId) {
        return null;
    }

    @Override
    public Excution DeleteFileGroup(Long filegroupId) {
        return null;
    }

    @Override
    public Excution Announce(announce a, organization o) {
        return null;
    }

    @Override
    public Excution DeleteAnnounce(Long annId) {
        return null;
    }
}
