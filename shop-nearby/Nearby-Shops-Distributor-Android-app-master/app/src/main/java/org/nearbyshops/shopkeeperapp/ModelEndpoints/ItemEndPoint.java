package org.nearbyshops.shopkeeperapp.ModelEndpoints;


import org.nearbyshops.shopkeeperapp.Model.Item;

import java.util.List;

/**
 * Created by sumeet on 30/6/16.
 */
public class ItemEndPoint {

    Integer itemCount;
    Integer offset;
    Integer limit;
    Integer max_limit;
    List<Item> results;


    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }


    public List<Item> getResults() {
        return results;
    }

    public void setResults(List<Item> results) {
        this.results = results;
    }

    public Integer getMax_limit() {
        return max_limit;
    }

    public void setMax_limit(Integer max_limit) {
        this.max_limit = max_limit;
    }
}
