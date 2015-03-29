package dino;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import dino.api.BadAddressException;
import dino.api.Directory;
import dino.api.Notebook;
import dino.api.NotebookAlreadyExistsException;
import dino.api.NotebookNotFoundException;


public class Dir implements Directory {

	private List<Notebook> notebooks;
	
	@Override
	public List<Notebook> getAllNotebooks() {
		// TODO Auto-generated method stub
		List<Notebook> returnval;
		returnval = notebooks;
		return returnval;
	}

	@Override
	public Notebook getNotebook(String id) {
		Notebook returnval;
		for(Notebook notebook: notebooks)
		{
			if(notebook.getId()==id)
			{
				returnval= notebook;
				return returnval;
			}
		}
		return null;
	}

	@Override
	public String createNotebook(String title, String primaryUrl)
			throws NotebookAlreadyExistsException, BadAddressException {
		// TODO Auto-generated method stub
		for(Notebook notebook:notebooks)
		{
			if(notebook.getTitle().equals(title))
			{
				throw new NotebookAlreadyExistsException();
			}
		}
		
		///todo add a function to talk to the primary server
		return "OK";
	}

	@Override
	public void deleteNotebook(String id) throws NotebookNotFoundException {
		// TODO Auto-generated method stub
		for(Notebook notebook : notebooks)
		{
			if(notebook.getId()==id)
			{
				//todo: call delete on the id for the primary server
				return;
			}
		}
		throw new NotebookNotFoundException();
	}

}
