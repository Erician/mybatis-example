package interfaces;
import daoclass.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface GoodsMapper {

    public void put(Goods goods);
    public Goods get(int goodsID);
    public void delete(int goodsID);
    public void updatePrice(@Param("goodsID")int goodsID, @Param("newPrice")float newPrice);

}
