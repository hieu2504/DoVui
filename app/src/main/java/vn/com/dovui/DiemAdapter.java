package vn.com.dovui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.com.dovui.model.QLDiem;
import vn.com.dovui.sqlite.QLDiemDAO;

public class DiemAdapter extends RecyclerView.Adapter<DiemAdapter.DiemHolder> {

    private Context context;
    private List<QLDiem> qlDiemList;
    private QLDiemDAO qlDiemDAO;
    public DiemAdapter(Context context,List<QLDiem> qlDiemList){
        this.context=context;
        this.qlDiemList=qlDiemList;
    }

    @NonNull
    @Override
    public DiemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,viewGroup,false);
        return new DiemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiemHolder holder, int position) {
        qlDiemDAO=new QLDiemDAO(context);
        qlDiemList=qlDiemDAO.diemCao();

        holder.tv_stt.setText(String.valueOf(position+1));
        holder.tv_name.setText(String.valueOf(qlDiemList.get(position).getName()));
        holder.tv_diem.setText(String.valueOf(qlDiemList.get(position).getDiem()));

    }

    @Override
    public int getItemCount() {
        return qlDiemList.size();
    }

    public static class DiemHolder extends RecyclerView.ViewHolder {
        private TextView tv_stt,tv_diem,tv_name;
        public DiemHolder(@NonNull View itemView) {
            super(itemView);
            tv_stt=itemView.findViewById(R.id.tv_stt_Cao);
            tv_diem=itemView.findViewById(R.id.tv_Diem_Cao);
            tv_name=itemView.findViewById(R.id.tv_Ten_Cao);


        }
    }
}
