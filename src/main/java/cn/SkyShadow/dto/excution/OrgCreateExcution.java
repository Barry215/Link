package cn.SkyShadow.dto.excution;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.enums.OrgCreateEnum;

public class OrgCreateExcution extends Excution {

	public OrgCreateExcution(OrgCreateEnum enum1) {
		super(enum1.getState(), enum1.getStateInfo());
	}

	public OrgCreateExcution(OrgCreateEnum enum1, Object obj) {
		super(enum1.getState(), enum1.getStateInfo(), obj);
	}

}
