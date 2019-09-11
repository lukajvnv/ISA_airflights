import { User } from 'src/app/models/user.model';

export class FriendShip {
  friendshipId: number;

  userWhoInvite: User;
  userWhoAccept: User;
  established: boolean;

  constructor(userWhoInvite: User, userWhoAccept: User, established: boolean) {
    this.userWhoInvite = userWhoInvite;
    this.userWhoAccept = userWhoAccept;
    this.established = established;
  }

}
