package todolist.youtube.com.codetutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import todolist.youtube.com.codetutor.bean.ToDo;
import todolist.youtube.com.codetutor.db.ToDoListDBAdapter;

public class MainActivity extends AppCompatActivity{

    private EditText title,subtitle,petname;
    private TextView textViewToDos;
    private Button buttonAddToDo, buttonRemoveToDo, buttonModifyToDo;

    private ToDoListDBAdapter toDoListDBAdapter;

    private List<ToDo> toDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoListDBAdapter=ToDoListDBAdapter.getToDoListDBAdapterInstance(getApplicationContext());
        toDos=toDoListDBAdapter.getAllToDos();
        title=(EditText)findViewById(R.id.title);
        subtitle=(EditText)findViewById(R.id.subtitle);
        petname=(EditText)findViewById(R.id.petname);
        textViewToDos=(TextView)findViewById(R.id.textViewToDos);
        buttonAddToDo=(Button)findViewById(R.id.buttonAddToDo);
        buttonAddToDo.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              addNewToDo();
          }
      });

    }

    @Override
    protected void onResume() {
        super.onResume();
        setNewList();
    }

    private void setNewList(){
        textViewToDos.setText(getToDoListString());
    }

    private void addNewToDo(){
        toDoListDBAdapter.insert(title.getText().toString(), subtitle.getText().toString(),petname.getText().toString());
        setNewList();
    }

    private void removeToDo(){
        toDoListDBAdapter.delete(Integer.parseInt(title.getText().toString()));
        setNewList();
    }

    private void modifyToDo(){
        int id=Integer.parseInt(title.getText().toString());
        String newToDO=subtitle.getText().toString();
        toDoListDBAdapter.modify(id,newToDO);
        setNewList();
    }



    private String getToDoListString(){
        toDos=toDoListDBAdapter.getAllToDos();
        if(toDos!=null && toDos.size()>0){
            StringBuilder stringBuilder=new StringBuilder("");
            for(ToDo toDo:toDos){
                stringBuilder.append(toDo.getToDo()+", "+toDo.getPlace()+", "+toDo.getPetname()+"\n");
            }
            return stringBuilder.toString();
        }else {
            return "No todo items";
        }
    }
}
