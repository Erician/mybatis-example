package testdao;
import daoclass.Goods;
import exception.DaoException;
import impl.GoodsMapperImpl;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TestGoodsMapperImpl {
    private static Logger logger = Logger.getLogger(TestGoodsMapperImpl.class);
    @Test
    public void putSucceed(){
        GoodsMapperImpl goodsMapper = new GoodsMapperImpl();
        Goods goods = new Goods(0,"apple", (float)20.20);
//        try{
//            goodsMapper.delete(0);
//        }catch (DaoException e){
//            e.printStackTrace();
//            System.out.println(e);
//        }
        try{
            goodsMapper.put(goods);
        }catch (DaoException e){
            StringWriter trace = new StringWriter();
            e.printStackTrace(new PrintWriter(trace));
            logger.error(trace.toString());
        }
    }
    @Test
    public void getSucceed(){
        GoodsMapperImpl goodsMapper = new GoodsMapperImpl();
        try{
            Goods goods = goodsMapper.get(0);
            System.out.println(goods.toString());
        }catch (DaoException e){
            e.printStackTrace();
        }
    }
    @Test
    public void deleteSucceed(){
        GoodsMapperImpl goodsMapper = new GoodsMapperImpl();
        try{
            goodsMapper.delete(0);
        }catch (DaoException e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
    @Test
    public void updatePriceSucceed(){
        GoodsMapperImpl goodsMapper = new GoodsMapperImpl();
        try{
            goodsMapper.updatePrice(1,(float)20.22);
        }catch (DaoException e){
            e.printStackTrace();
        }

    }

}
