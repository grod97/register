package helpers;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;


public class query extends DBcon {
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	private ArrayList <JSONObject> array = new ArrayList<JSONObject>();
	
	public query() {
		super();
	}
	
	private JSONObject getData() throws SQLException, JSONException {
		JSONObject userData = new JSONObject();
		if(this.rs.next()) {		
			this.rsmd = rs.getMetaData();
			for(int i = 1; i <= this.rsmd.getColumnCount(); i++) {
				userData.put(rsmd.getColumnLabel(i), rs.getObject(i));
			}
		}
		return userData;
	}
	
	private ArrayList<JSONObject> getArray() throws SQLException, JSONException {
		
		int f = 0;
		
		while(this.rs.next()) {	
			JSONObject userData = new JSONObject();
			this.rsmd = rs.getMetaData();
			for(int i = 1; i <= this.rsmd.getColumnCount(); i++) {
				userData.put(rsmd.getColumnLabel(i), rs.getObject(i));
			}
			System.out.println("content: "+ userData);
			array.add( f,userData);
			f++;	
			
		}
		System.out.println("array f: "+ array);
		return array;	
	}
	
		
	//Verificar el email
		public boolean VerificarCorreo(String value) throws SQLException{
			this.rs = executeStatement("BuscarCorreo", value);
			return this.rs.next();
		}
		
	//Verifica si el usuario existe y retorna sus datos
		public JSONObject ObtenerDatos (JSONObject user)throws SQLException, JSONException{
			String encriptada = hashingPwd.HashPassword(user.getString("password"));
			this.rs = executeStatement("VerificarIngreso", user.getString("email"), encriptada);
			return this.getData();
		}
	
		
	//Registrar la cuenta
		public boolean Registrar(JSONObject data) throws SQLException, JSONException{
		 String clave = hashingPwd.HashPassword(data.getString("passsword"));
			int i = executeUpdate("IngresarUsuario", data.getString("nombre"), data.getString("usuario"),
					data.getString("correo"), data.getString("telefono"), data.getString("cedula"), clave);
			return (i == 1)?true:false;
		}
        }