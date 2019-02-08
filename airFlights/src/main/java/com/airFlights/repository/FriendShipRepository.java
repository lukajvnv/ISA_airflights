package com.airFlights.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.airFlights.model.user.Friendship;
import com.airFlights.model.user.User;

public interface FriendShipRepository extends JpaRepository<Friendship, Integer> {
	
	//List<Friendship> findByUserWhoInviteAndFindByEstablished(User user, Boolean established);
	//List<Friendship> findByEstablishedTrue();
	
	List<Friendship> findByUserWhoInvite(User user);
	Friendship findByUserWhoInviteAndUserWhoAccept(User inviter, User accepter);
	
	@Modifying
	@Query("DELETE FROM Friendship f WHERE f.userWhoInvite = ?1 and f.userWhoAccept= ?2")
	void deleteFriendsip(User inviter, User accepter);


}
