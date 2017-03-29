package services;

import java.util.Observer;

import model.ShoppingList;

public interface AlertService extends Observer{
	public boolean hasAlertForUser(int id, ShoppingList list);
	
	public String getAlertForUser(int id);
}
