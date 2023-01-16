package com.relo.zzim;

import java.util.List;

import com.relo.exception.FindException;

public class ZzimService {
	private ZzimDAOOracle dao;

	public ZzimService() {
		dao = new ZzimDAOOracle();
	}

	public List<ZzimDTO> getById(String id) throws FindException {
		return dao.selectById(id);
	}

	public void addZzim(ZzimVo vo) throws FindException {
		dao.insertZzim(vo);
	}

	public void delZzim(ZzimVo vo) throws FindException {
		dao.deleteZzim(vo);
	}

	public void delZzimAll(int pNum) throws FindException {
		dao.deleteZzimAll(pNum);
	}
}
