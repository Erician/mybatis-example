package daoclass;

public class Goods {

    public int id;
    public String name;
    public float price;
    public Goods(){
        id = 0;
        name = "";
        price = 0;
    }
    public Goods(int goodsID, String goodsName, float goodsPrice){
        id = goodsID;
        name = goodsName;
        price = goodsPrice;
    }
    public String toString(){
        String goodsString = "id:" + String.valueOf(id) + "\t"
                             +"name:" + name + "\t"
                             +"price:" + String.valueOf(price);
        return  goodsString;
    }

}
