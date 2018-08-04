package org.nearbyshops.shopkeeperapp.CancelledOrdersHD.ReturnedByDeliveryGuy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.nearbyshops.shopkeeperapp.Model.Order;
import org.nearbyshops.shopkeeperapp.Model.DeliveryAddress;
import org.nearbyshops.shopkeeperapp.ModelStats.OrderStats;
import org.nearbyshops.shopkeeperapp.OrderHistoryHD.Utility.UtilityOrderStatus;
import org.nearbyshops.shopkeeperapp.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sumeet on 13/6/16.
 */
public class AdapterReturnedByDG extends RecyclerView.Adapter<AdapterReturnedByDG.ViewHolder>{


    private List<Order> dataset = null;
//    private Context context;
    private NotifyCancelHandover notifications;


    public AdapterReturnedByDG(List<Order> dataset, NotifyCancelHandover notifications) {
        this.dataset = dataset;
//        this.context = context;
        this.notifications = notifications;

    }

    @Override
    public AdapterReturnedByDG.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_returned_by_delivery_guy,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterReturnedByDG.ViewHolder holder, int position) {

        if(dataset!=null)
        {
            if(dataset.size() <= position)
            {
                return;
            }

            Order order = dataset.get(position);
            DeliveryAddress deliveryAddress = order.getDeliveryAddress();
            OrderStats orderStats = order.getOrderStats();

            holder.orderID.setText("Order ID : " + order.getOrderID());
            holder.dateTimePlaced.setText("Placed : " + order.getDateTimePlaced().toLocaleString());


            holder.deliveryAddressName.setText(deliveryAddress.getName());

            holder.deliveryAddress.setText(deliveryAddress.getDeliveryAddress() + ",\n"
                                            + deliveryAddress.getCity() + " - " + deliveryAddress.getPincode());

            holder.deliveryAddressPhone.setText("Phone : " + deliveryAddress.getPhoneNumber());

            holder.numberOfItems.setText(orderStats.getItemCount() + " Items");
            holder.orderTotal.setText("| Total : " + (orderStats.getItemTotal() + order.getDeliveryCharges()));

            holder.currentStatus.setText("Current Status : " + UtilityOrderStatus.getStatus(order.getStatusHomeDelivery(),false,false));
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{


        @Bind(R.id.order_id)
        TextView orderID;

        @Bind(R.id.dateTimePlaced)
        TextView dateTimePlaced;

        @Bind(R.id.deliveryAddressName)
        TextView deliveryAddressName;

        @Bind(R.id.deliveryAddress)
        TextView deliveryAddress;

        @Bind(R.id.deliveryAddressPhone)
        TextView deliveryAddressPhone;


        @Bind(R.id.numberOfItems)
        TextView numberOfItems;

        @Bind(R.id.orderTotal)
        TextView orderTotal;

        @Bind(R.id.currentStatus)
        TextView currentStatus;

        @Bind(R.id.acceptHandoverButton)
        TextView cancelHandoverButton;


        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);


        }


        @OnClick(R.id.acceptHandoverButton)
        void onClickConfirmButton(View view)
        {
            notifications.notifyCancelHandover(dataset.get(getLayoutPosition()));
        }

    }


    interface NotifyCancelHandover {
        void notifyCancelHandover(Order order);
    }

}
