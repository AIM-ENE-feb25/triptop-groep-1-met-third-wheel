package com.prototype_state.prototype.service;

import com.prototype_state.prototype.MockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BouwsteenService {
 private final MockRepository mockRepository;
 @Autowired
 public BouwsteenService(MockRepository mockRepository) {
  this.mockRepository = mockRepository;
 }

 public String plan(int id) {
  var bouwsteen = mockRepository.getBouwsteenById(id);
  bouwsteen.plan();
  mockRepository.saveBouwsteen(bouwsteen);
  return getStatus(id);
 }

 public String pasAan(int id) {
  var bouwsteen = mockRepository.getBouwsteenById(id);
          bouwsteen.pasAan();
  mockRepository.saveBouwsteen(bouwsteen);
  return getStatus(id);
 }

 public String regel(int id) {
  var bouwsteen = mockRepository.getBouwsteenById(id);
  bouwsteen.regel();
  mockRepository.saveBouwsteen(bouwsteen);
  return getStatus(id);
 }

 public String betaal(int id) {
  var bouwsteen = mockRepository.getBouwsteenById(id);
  bouwsteen.betaal();
  mockRepository.saveBouwsteen(bouwsteen);
  return getStatus(id);
 }

 public String voerUit(int id) {
  var bouwsteen = mockRepository.getBouwsteenById(id);
  bouwsteen.voerUit();
  mockRepository.saveBouwsteen(bouwsteen);
  return getStatus(id);
 }

 public String annuleer(int id) {
  var bouwsteen = mockRepository.getBouwsteenById(id);
  bouwsteen.annuleer();
  mockRepository.saveBouwsteen(bouwsteen);
  return getStatus(id);
 }

 public String getStatus(int id) {
  if(mockRepository.getBouwsteenById(id).getStatus() == null) {
   return "Huidige status: " + mockRepository.getBouwsteenById(id).getStatus();
  }else{
   return "Huidige status: " + mockRepository.getBouwsteenById(id).getStatus().getStatusName();
  }
 }
}
