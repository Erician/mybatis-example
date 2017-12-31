package impl;
import daoclass.Goods;
import exception.DaoException;
import interfaces.GoodsMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class GoodsMapperImpl implements GoodsMapper{

    public SqlSessionFactory _sqlSessionFactory;
    public GoodsMapperImpl() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            _sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void put(Goods goods)throws DaoException{
        SqlSession session = _sqlSessionFactory.openSession(true);
        try {
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            mapper.put(goods);
        }catch (Exception e){
            DaoException daoException = new DaoException();
            daoException.initCause(e);
            throw daoException;
        }
        finally {
            session.close();
        }
    }

    public Goods get(int goodsID) throws DaoException{
        SqlSession session = _sqlSessionFactory.openSession();
        try {
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            Goods goods = mapper.get(goodsID);
            return  goods;
        }catch (Exception e){
            DaoException daoException = new DaoException();
            daoException.initCause(e);
            throw daoException;
        }
        finally {
            session.close();
        }
    }

    public void delete(int goodsID)throws DaoException{
        SqlSession session = _sqlSessionFactory.openSession(false);
        try {
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            mapper.delete(goodsID);
            session.commit();
        }catch (Exception e){
            System.out.println(e);
            DaoException daoException = new DaoException();
            daoException.initCause(e);
            throw daoException;
        }
        finally {
            session.close();
        }
    }

    public void updatePrice(int goodsID, float newPrice) throws DaoException{
        SqlSession session = _sqlSessionFactory.openSession(false);
        try {
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            mapper.updatePrice(goodsID,newPrice);
            session.commit();
        }catch (Exception e){
            DaoException daoException = new DaoException();
            daoException.initCause(e);
            throw daoException;
        }
        finally {
            session.close();
        }
    }
}