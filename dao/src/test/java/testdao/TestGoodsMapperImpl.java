package testdao;
import daoclass.Goods;
import impl.GoodsMapperImpl;
import org.junit.Test;

public class TestGoodsMapperImpl {

    @Test
    public void putSucceed(){
        GoodsMapperImpl goodsMapper = new GoodsMapperImpl();
        goodsMapper.delete(0);
        Goods goods = new Goods(0,"苹果", (float)20.20);
        goodsMapper.put(goods);
    }
    @Test
    public void getSucceed(){
        GoodsMapperImpl goodsMapper = new GoodsMapperImpl();
        Goods goods = goodsMapper.get(0);
        System.out.println(goods.toString());
    }
    @Test
    public void deleteSucceed(){
        GoodsMapperImpl goodsMapper = new GoodsMapperImpl();
        goodsMapper.delete(0);
    }
    @Test
    public void updatePriceSucceed(){
        GoodsMapperImpl goodsMapper = new GoodsMapperImpl();
        goodsMapper.updatePrice(1,(float)20.22);
    }

}
