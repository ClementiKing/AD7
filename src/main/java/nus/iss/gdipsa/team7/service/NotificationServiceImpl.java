package nus.iss.gdipsa.team7.service;

import nus.iss.gdipsa.team7.model.Notification;

import nus.iss.gdipsa.team7.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    NotificationRepository ntRepo;
    @Override
    public void save(Notification nt) {
        ntRepo.save(nt);
    }
}
