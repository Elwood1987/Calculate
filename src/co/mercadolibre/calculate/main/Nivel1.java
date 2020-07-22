package co.mercadolibre.calculate.main;

import co.mercadolibre.calculate.model.Coupon;

import java.util.*;

/**
 * @Author: Cristian E Castro Lara
 */
public class Nivel1 {
    public static List<String> calculate (Map<String, Float> items, Float amount) {
        try{
        ArrayList orderList = (ArrayList) orderMap(items);
        Coupon coupon = new Coupon();
        for(int i = 0; i < orderList.size(); i++) {
            if (items.get(orderList.get(i))>amount){
                continue;
            }else {
                Coupon couponTmp = new Coupon();
                couponTmp.getItemIds().add(orderList.get(i));
                couponTmp.setAmount(couponTmp.getAmount()+items.get(orderList.get(i)));
                for (int j = 0; j < orderList.size(); j++) {
                    if (j!=i){
                        if( couponTmp.getAmount() + items.get(orderList.get(j)) <= amount) {
                            couponTmp.getItemIds().add(orderList.get(j));
                            couponTmp.setAmount(couponTmp.getAmount()+items.get(orderList.get(j)));
                        }
                    }
                }
                if(couponTmp.getAmount()>coupon.getAmount()){
                    coupon = couponTmp;
                }
            }
        }
        return coupon.getItemIds();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static List orderMap(Map<String, Float> items){
        try {
            Iterator iterator = items.entrySet().iterator();
            ArrayList orderList = new ArrayList();
            while (iterator.hasNext()){
                Map.Entry entry = (Map.Entry)iterator.next();
                orderList.add(entry.getKey());
            }
            Collections.sort(orderList);
            return orderList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Map mapa = new HashMap();

        mapa.put("MLA1", (float) 100);
        mapa.put("MLA2", (float) 210);
        mapa.put("MLA3",  (float) 260);
        mapa.put("MLA4", (float) 80);
        mapa.put("MLA5", (float) 90);
        ArrayList arr = (ArrayList) calculate(mapa, (float) 500);
        for(int k = 0; k < arr.size(); k++) {
            System.out.println(arr.get(k)+"");
        }
    }
}


