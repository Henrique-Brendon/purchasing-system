package model.dao;

import java.sql.ResultSet;
import java.util.List;

import Util.cep.CepInfo;

public interface CepInfoDao {
    ResultSet insert(CepInfo cepInfo);
    List<CepInfo> findAll();
}
