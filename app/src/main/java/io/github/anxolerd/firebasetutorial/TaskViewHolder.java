package io.github.anxolerd.firebasetutorial;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    View mView;

    public TaskViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setName(String name) {
        TextView field = (TextView) mView.findViewById(R.id.textViewName);
        field.setText(name);
    }

    public void setDescription(String description) {
        TextView field = (TextView) mView.findViewById(R.id.textViewDescription);
        field.setText(description);
    }

    public void setOnCheckboxClick(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        CheckBox field = (CheckBox) mView.findViewById(R.id.checkBoxIsDone);
        field.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setIsDone(@NonNull Boolean isDone) {
        CheckBox field = (CheckBox) mView.findViewById(R.id.checkBoxIsDone);
        field.setChecked(isDone);
    }
}
