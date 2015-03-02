package pe.friki.asyntask;

import android.content.Context;

/**
 * Created by ios2015 on 3/2/15.
 */
public class ManageAsyntask {

    Context context;

    public ManageAsyntask(Context context) {
        this.context = context;
    }

    public void listar(String url) {
        ListarTodo obj = new ListarTodo(context);
        obj.execute(url);
    }

}
