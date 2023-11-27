package com.waleed.oopsproject.Messages;

import com.waleed.oopsproject.Bids.BidModel;
import com.waleed.oopsproject.Bids.BidRepository;
import com.waleed.oopsproject.Products.ProductModel;
import com.waleed.oopsproject.Products.ProductRepository;
import com.waleed.oopsproject.Users.UserModel;
import com.waleed.oopsproject.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BidRepository bidRepository;

    // Create
    public MessageModel addMessage(MessageModel messageModel, Long productId, Long userId, Long receiverId) {
        messageModel.setProduct(productRepository.findById(productId).orElse(null));
        messageModel.setSender(userRepository.findById(userId).orElse(null));
        messageModel.setReceiver(userRepository.findById(receiverId).orElse(null));
        // set timestamp in string format
        messageModel.setTimestamp(java.time.LocalDateTime.now().toString());
        return messageRepository.save(messageModel);
    }

    // Read
    public Iterable<MessageModel> getMessagesByProductId(Long productId) {
        return messageRepository.findAllByProductId(productId);
    }

    public Iterable<MessageModel> getAllMessages() {
        return messageRepository.findAll();
    }

    // Get Messages by Sender
    public Iterable<MessageModel> getMessagesBySenderId(Long senderId) {
        UserModel sender = userRepository.findById(senderId).orElse(null);
        assert sender != null;
        return messageRepository.findAllBySender(sender);
    }

    // Get Messages by Receiver
    public Iterable<MessageModel> getMessagesByReceiverId(Long receiverId) {
        UserModel receiver = userRepository.findById(receiverId).orElse(null);
        Iterable<ProductModel> products = productRepository.findAllByUser(receiver);
        List<MessageModel> messages = new java.util.ArrayList<>();
        for (ProductModel product : products) {
            messages.addAll((List<MessageModel>) messageRepository.findAllByProduct(product));
        }
        return messages;
    }

    public Iterable<MessageModel> getMessagesFromHighestBidder(Long productId) {
        ProductModel productModel = productRepository.findById(productId).orElse(null);
        assert productModel != null;
        List<MessageModel> messages = new java.util.ArrayList<>();
        List<BidModel> bids = bidRepository.findAllByProduct(productModel);
        int highestBid = 0;
        for (BidModel bid : bids) {
            if (bid.getBid() > highestBid) {
                highestBid = bid.getBid();
            }
        }
        for (BidModel bid : bids) {
            if (bid.getBid() == highestBid) {
                messages.addAll((List<MessageModel>) messageRepository.findAllByProductAndSender(productModel, bid.getUser()));
                messages.addAll((List<MessageModel>) messageRepository.findAllByProductAndReceiver(productModel, bid.getUser()));
                return messages;
            }
        }
        return messages;
    }

    // Get Messages for bidder view
    public Iterable<MessageModel> getMessagesByProductAndSender(Long productId, Long senderId) {
        ProductModel productModel = productRepository.findById(productId).orElse(null);
        assert productModel != null;
        UserModel sender = userRepository.findById(senderId).orElse(null);
        UserModel receiver = userRepository.findById(productModel.getUser().getUserId()).orElse(null);
        assert sender != null;
        assert receiver != null;
        List<MessageModel> messages = new java.util.ArrayList<>();
        messages.addAll((List<MessageModel>) messageRepository.findAllByProductAndSender(productModel, sender));
        messages.addAll((List<MessageModel>) messageRepository.findAllByProductAndReceiver(productModel, sender));
        return messages;
    }
}
