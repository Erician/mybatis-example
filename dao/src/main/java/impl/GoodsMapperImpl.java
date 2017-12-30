package impl;
import daoclass.Goods;
import interfaces.GoodsMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class GoodsMapperImpl implements GoodsMapper{

    public SqlSessionFactory _sqlSessionFactory;
    public GoodsMapperImpl() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            _sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void put(Goods goods){
        SqlSession session = _sqlSessionFactory.openSession(false);
        try {
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            mapper.put(goods);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Goods get(int goodsID){
        SqlSession session = _sqlSessionFactory.openSession();
        try {
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            Goods goods = mapper.get(goodsID);
            return  goods;
        } finally {
            session.close();
        }
    }

    public void delete(int goodsID){
        SqlSession session = _sqlSessionFactory.openSession(false);
        try {
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            mapper.delete(goodsID);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updatePrice(int goodsID, float newPrice){
        SqlSession session = _sqlSessionFactory.openSession(false);
        try {
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            mapper.updatePrice(goodsID,newPrice);
            session.commit();
        } finally {
            session.close();
        }
    }
}