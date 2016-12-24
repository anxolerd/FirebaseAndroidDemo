package io.github.anxolerd.firebasetutorial;

import android.widget.CompoundButton;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.*;

import java.util.HashMap;

public class FirebaseTaskRecyclerAdapter extends FirebaseRecyclerAdapter<Task, TaskViewHolder> {
    private DatabaseReference ref;

    public FirebaseTaskRecyclerAdapter(DatabaseReference ref) {
        super(Task.class, R.layout.task_list_item, TaskViewHolder.class, ref);
        this.ref = ref;
    }

    @Override
    protected void populateViewHolder(TaskViewHolder viewHolder, final Task model, int position) {

        viewHolder.setName(model.getName());
        viewHolder.setDescription(model.getDescription());
        viewHolder.setIsDone(model.getDone());


        viewHolder.setOnCheckboxClick(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isDone) {
                final Query q = ref.orderByChild("id").equalTo(model.getId());
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        DataSnapshot nodeDataSnapshot = dataSnapshot.getChildren().iterator().next();

                        HashMap<String, Object> result = new HashMap<String, Object>();
                        result.put("done", isDone);
                        nodeDataSnapshot.getRef().updateChildren(result);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }

    @Override
    public void onViewRecycled(TaskViewHolder holder) {
        holder.setOnCheckboxClick(null);
        super.onViewRecycled(holder);
    }
}
