package services;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import model.*;
import persistence.impl.*;

public class CarruselService {
	
	public List<Vendible> getVendibles(Usuario user) throws IOException{
	return Sistema.sugerirVisitas(user);
	
	}
	
}