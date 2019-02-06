package com.airFlights.service.avio;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.assertj.core.internal.Throwables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airFlights.dto.UserDTO;
import com.airFlights.model.user.Friendship;
import com.airFlights.model.user.User;
import com.airFlights.repository.FriendShipRepository;
import com.airFlights.repository.UserRepository;

@Service
public class FriendShipService {
	
	@Autowired
	private FriendShipRepository friendshipRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllFriendsByUser(String username){
		User user = userRepository.findByUsername(username);

		List<Friendship> acceptingPendingFriendShip= friendshipRepository.findByUserWhoInvite(user);
		List<User> friends = new ArrayList<User>();
		
		for(Friendship f : acceptingPendingFriendShip) {
			if(f.getEstablished()) {
				friends.add(f.getUserWhoAccept());
			}
		}
		return friends;
	}
	
	public List<User> getAllFriendsRequestByUser(String username){
		User user = userRepository.findByUsername(username);
		Set<Friendship> requests = user.getRequestedFriendships();
		List<User> friends = new ArrayList<User>();
		
		for(Friendship f : requests) {
		   if(!f.getEstablished()) {
			   friends.add(f.getUserWhoInvite());
		   }
		}
		return friends;
	}
	
	public void addFriend(String currentUsserUsername, UserDTO toAdd) throws Exception{
		User current = userRepository.findByUsername(currentUsserUsername);
		User friendToAdd = userRepository.findByUsername(toAdd.getUsername());
		
		Friendship potentialFriendship = new Friendship(current, friendToAdd, false);
		
		Set<Friendship> friendsips = current.getFriendships();
		for(Friendship f: friendsips) {
			if(f.getUserWhoAccept().getUsername() == friendToAdd.getUsername()) {
				throw new Exception();
			}
		}
		friendshipRepository.saveAndFlush(potentialFriendship);
		
		friendsips.add(potentialFriendship);
		
		Set<Friendship> requests = friendToAdd.getRequestedFriendships();
		requests.add(potentialFriendship);
		
	}
	
	public List<User> removeFriend(String currentUsserUsername, UserDTO toAdd){
		User inviter = userRepository.findByUsername(currentUsserUsername);
		User accepter = userRepository.findByUsername(toAdd.getUsername());
		
		friendshipRepository.deleteFriendsip(inviter, accepter);
		friendshipRepository.deleteFriendsip(accepter, inviter);

		return getAllFriendsByUser(currentUsserUsername);
	}
	
	public List<User> acceptFriend(String currentUsserUsername, UserDTO toAdd){
		User accepter = userRepository.findByUsername(currentUsserUsername);
		User inviter = userRepository.findByUsername(toAdd.getUsername());
		
		Friendship friendshipToUpdate = friendshipRepository.findByUserWhoInviteAndUserWhoAccept(inviter, accepter);
		friendshipToUpdate.setEstablished(true);
		
		Friendship newFriendship = new Friendship(accepter, inviter, true);
		friendshipRepository.save(newFriendship);
		
		
		/*Set<Friendship> friendsips = current.getFriendships();
		friendsips.add(potentialFriendship);
		
		Set<Friendship> requests = friendToAdd.getRequestedFriendships();
		requests.add(potentialFriendship);*/
		
		return getAllFriendsRequestByUser(currentUsserUsername);
	}
	
	public List<User> refuseFriend(String currentUsserUsername, UserDTO toAdd){
		User accepter = userRepository.findByUsername(currentUsserUsername);
		User inviter = userRepository.findByUsername(toAdd.getUsername());
		
		friendshipRepository.deleteFriendsip(inviter, accepter);
		
		
		return getAllFriendsRequestByUser(currentUsserUsername);
	}
	

}
