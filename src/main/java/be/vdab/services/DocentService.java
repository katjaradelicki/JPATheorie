package be.vdab.services;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import be.vdab.dao.DocentDAO;
import be.vdab.entities.Docent;
import be.vdab.exceptions.DocentNietGevondenException;
import be.vdab.filters.JPAFilter;
import be.vdab.util.VoornaamInfo;

public class DocentService {
	  private final DocentDAO docentDAO = new DocentDAO(); 
	  public Docent read(long docentNr) {
		  return docentDAO.read(docentNr);
		}
		public void create(Docent docent) {
		  docentDAO.beginTransaction();
		  docentDAO.create(docent);
		  docentDAO.commit();
		}
		public void delete(long docentNr) {
		    docentDAO.beginTransaction();
		    docentDAO.delete(docentNr);
		    docentDAO.commit();
		}
		public void opslag(long docentNr, BigDecimal percentage) {
		  docentDAO.beginTransaction();
		  Docent docent = docentDAO.read(docentNr);
		  if (docent == null) {
		    throw new DocentNietGevondenException();
		  }
		  docent.opslag(percentage);
		  docentDAO.commit();
		} 
		public Iterable<Docent> findByWeddeBetween(
				  BigDecimal van, BigDecimal tot, int vanafRij, int aantalRijen) {
				  return docentDAO.findByWeddeBetween(van,tot, vanafRij,aantalRijen);
				}
		public Iterable<VoornaamInfo> findVoornamen() {
			  return docentDAO.findVoornamen();
			} 
		public BigDecimal findMaxWedde() {
			  return docentDAO.findMaxWedde();
			} 
	}
