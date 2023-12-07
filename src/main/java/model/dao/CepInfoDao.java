package model.dao;

import java.sql.ResultSet;

import Util.cep.CepInfo;

public interface CepInfoDao {
    ResultSet insert(CepInfo cepInfo);
}
