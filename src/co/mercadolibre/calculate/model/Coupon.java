package co.mercadolibre.calculate.model;

import java.util.ArrayList;

public class Coupon {
    private ArrayList<String> itemIds;
    private Float amount;

    public Coupon() {
        itemIds = new ArrayList<>();
        amount = (float) 0;
    }

    public Coupon(ArrayList itemIds, Float amount) {
        this.itemIds = itemIds;
        this.amount = amount;
    }

    public ArrayList getItemIds() {
        return itemIds;
    }

    public void setItemIds(ArrayList itemIds) {
        this.itemIds = itemIds;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
