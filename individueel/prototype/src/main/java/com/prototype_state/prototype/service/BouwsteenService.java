package com.prototype_state.prototype.service;

import java.util.HashMap;
import java.util.Map;
import com.prototype_state.prototype.domain.Bouwsteen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BouwsteenService {
 private Map<Integer, Bouwsteen> bouwstenen = new HashMap<>();

 @Autowired
 public BouwsteenService() {
  bouwstenen.put(1, new Bouwsteen("Hotel", 1));
 }

 public String plan(int id) {
  getBouwsteen(id).plan();
  return getStatus(id);
 }

 public String pasAan(int id) {
  getBouwsteen(id).pasAan();
  return getStatus(id);
 }

 public String regel(int id) {
  getBouwsteen(id).regel();
  return getStatus(id);
 }

 public String betaal(int id) {
  getBouwsteen(id).betaal();
  return getStatus(id);
 }

 public String voerUit(int id) {
  getBouwsteen(id).voerUit();
  return getStatus(id);
 }

 public String annuleer(int id) {
  getBouwsteen(id).annuleer();
  return getStatus(id);
 }

 public String getStatus(int id) {
  if (getBouwsteen(id).getStatus() == null) {
   return "Huidige status: " + getBouwsteen(id).getStatus();
  } else {
   return "Huidige status: " + getBouwsteen(id).getStatus().getStatusName();
  }
 }

 private Bouwsteen getBouwsteen(int id) {
  return bouwstenen.getOrDefault(id, new Bouwsteen("Onbekend", id));
 }
}
