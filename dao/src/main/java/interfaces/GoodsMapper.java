package interfaces;
import daoclass.Goods;
import exception.DaoException;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface GoodsMapper {

    public void put (Goods goods) throws DaoException;
    public Goods get(int goodsID) throws DaoException;
    public void delete(int goodsID) throws DaoException;
    public void updatePrice(@Param("goodsID")int goodsID, @Param("newPrice")float newPrice) throws DaoException;

}
