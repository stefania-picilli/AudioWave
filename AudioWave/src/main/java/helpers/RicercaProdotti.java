package helpers;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import model.dao.ProdottoDAO;
import model.dto.ProdottoBean;

public class RicercaProdotti {

	public static Collection<ProdottoBean> search(ProdottoDAO prodottoDAO, String search) throws SQLException {
		
		search = search.trim();
		String[] array = search.split(" ");
		
		List<ProdottoBean> list = new LinkedList<>();
		List<ProdottoBean> listTemp = null;
		
		
		for(int i = 0; i < array.length; i++) {
			
			listTemp = (LinkedList<ProdottoBean>) prodottoDAO.doRetrieveByString(array[i]);
			
			if(listTemp == null || listTemp.size() == 0)
				continue;
			
			addItems(list, listTemp);
			
		}
		
		return list;
		
		
	}
	
	private static void addItems(List<ProdottoBean> list, List<ProdottoBean> listTemp) {
		
		if(listTemp == null || listTemp.isEmpty())
			return;
		
		int j = 0;
		
		for(int i = 0; i < list.size(); i++) {
			
			if(j >= listTemp.size())
				break;
			
			if(listTemp.get(j).getCodiceProdotto() < list.get(i).getCodiceProdotto()) {
				
				list.add(i, listTemp.get(j));
				j++;
				
				
			}else if(listTemp.get(j).getCodiceProdotto() == list.get(i).getCodiceProdotto()) {
				
				j++;
				
			}
			
		}
		
		//se ci sono altri elementi in listTemp li aggiunge alla fine di list
		
		for(int i = j; i < listTemp.size(); i++)
			list.add(listTemp.get(i));
			
		
	}
	
	public static double maxPrezzo(List<ProdottoBean> list) {
		
		if(list == null)
			return 0;
		
		double max = 0;
		
		for(ProdottoBean prodotto : list) 
			if(prodotto.getPrezzoConIva() > max)
				max = prodotto.getPrezzoConIva();
			
		return max;
		
	}
	
}



