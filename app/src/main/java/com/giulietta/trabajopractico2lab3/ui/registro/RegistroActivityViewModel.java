package com.giulietta.trabajopractico2lab3.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.giulietta.trabajopractico2lab3.model.Usuario;
import com.giulietta.trabajopractico2lab3.request.ApiClient;
import com.giulietta.trabajopractico2lab3.ui.login.MainActivity;

public class RegistroActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Usuario> mUsuario;

    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Usuario> getMUsuario(){
        if(mUsuario == null){
            mUsuario = new MutableLiveData<>();

        }
        return mUsuario;
    }

    public void leerDatos(boolean bool){
        if(bool){
            mUsuario.setValue(ApiClient.leer(context));
        }
    }

    public void editar(Usuario usuario){
        if(usuario.getDni().isEmpty() || usuario.getApellido().isEmpty() || usuario.getNombre().isEmpty() || usuario.getMail().isEmpty() ||usuario.getPassword().isEmpty()){
            Toast.makeText(context, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            if(ApiClient.guardar(context, usuario)) {
                Toast.makeText(context, "Usuario actualizado correctamente", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            } else {
                Toast.makeText(context, "No se pudo actualizar/guardar correctamente", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
