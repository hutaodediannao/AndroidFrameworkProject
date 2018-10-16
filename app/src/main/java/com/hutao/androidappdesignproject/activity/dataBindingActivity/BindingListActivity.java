package com.hutao.androidappdesignproject.activity.dataBindingActivity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hutao.androidappdesignproject.BR;
import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;
import com.hutao.androidappdesignproject.databinding.ActivityBindingListBinding;
import com.hutao.androidappdesignproject.databinding.ItemBindTextviewBinding;
import com.hutao.androidappdesignproject.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: dataBinding列表绑定
 * 作者: 胡涛
 * 时间: 2018-10-15 15:26
 */
public class BindingListActivity extends ToolBarActivity {

    @Override
    public String getToolbarTitleContent() {
        return "列表绑定";
    }

    private ActivityBindingListBinding mBinding;
    private EmployeeAdapter mAdapter;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootView = LayoutInflater.from(this).inflate(R.layout.activity_binding_list, null);
        setContentView(rootView);

        mBinding = DataBindingUtil.bind(rootView);
        mBinding.setPresenter(new Presenter());

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new EmployeeAdapter(this);
        mBinding.recyclerView.setAdapter(mAdapter);
        mAdapter.setListener(new EmployeeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(User employee) {
                Toast.makeText(BindingListActivity.this, employee.getName().get(), Toast.LENGTH_SHORT).show();
            }
        });

        List<User> employeeList = new ArrayList<>();
        employeeList.add(new User("Cheng1", 28, true));
        employeeList.add(new User("Cheng1", 29, false));
        employeeList.add(new User("Cheng1", 30, true));
        employeeList.add(new User("Cheng1", 31, false));
        mAdapter.addAll(employeeList);

    }

    public class Presenter {
        public void onClickAddItem(View view) {
            mAdapter.add(new User("新增", 26, false));
        }

        public void onClickRemoveItem(View view) {
            mAdapter.remove();
        }
    }

    public static class EmployeeAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private LayoutInflater mInflater;
        private OnItemClickListener mListener;
        private List<User> mEmployeeList;

        public static final int ITEM_VIEW_TYPE_ON = 1;
        public static final int ITEM_VIEW_TYPE_OFF = 2;

        public void setListener(OnItemClickListener listener) {
            this.mListener = listener;
        }

        public interface OnItemClickListener {
            void onItemClick(User employee);
        }

        public EmployeeAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
            mEmployeeList = new ArrayList<>();
        }

        @Override
        public int getItemViewType(int position) {
            User employee = mEmployeeList.get(position);
            if (employee.getIsHappy().get()) {
                return ITEM_VIEW_TYPE_OFF;
            } else {
                return ITEM_VIEW_TYPE_ON;
            }
        }

        @Override
        public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ItemBindTextviewBinding binding;
            if (viewType == ITEM_VIEW_TYPE_ON) {
                binding = DataBindingUtil.inflate(mInflater, R.layout.item_bind_textview, parent, false);
            } else {
                binding = DataBindingUtil.inflate(mInflater, R.layout.item_bind_textview, parent, false);
            }
            return new BindingViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(BindingViewHolder holder, int position) {
            final User employee = mEmployeeList.get(position);
            holder.getBinding().setVariable(BR.user, employee);
            holder.getBinding().executePendingBindings();
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        mListener.onItemClick(employee);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mEmployeeList.size();
        }

        public void addAll(List<User> employeeList) {
            mEmployeeList.addAll(employeeList);
            notifyDataSetChanged();
        }

        public void add(User employee) {
            mEmployeeList.add(employee);
            notifyDataSetChanged();
        }

        public void remove() {
            if (mEmployeeList.size() == 0) {
                return;
            }

            int position = mEmployeeList.size() - 1;
            mEmployeeList.remove(position);
            notifyDataSetChanged();
        }
    }


    public static class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
        private T mBinding;

        public BindingViewHolder(T binding) {
            super(binding.getRoot());

            mBinding = binding;
        }

        public T getBinding() {
            return mBinding;
        }
    }

}
