package com.dyi.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent tweets in
 * the user's news feed. Your design should support the following methods:
 * 
 * postTweet(userId, tweetId): Compose a new tweet. getNewsFeed(userId):
 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
 * the news feed must be posted by users who the user followed or by the user
 * herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee. Example:
 * 
 * Twitter twitter = new Twitter();
 * 
 * // User 1 posts a new tweet (id = 5). twitter.postTweet(1, 5);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * 
 * // User 1 follows user 2. twitter.follow(1, 2);
 * 
 * // User 2 posts a new tweet (id = 6). twitter.postTweet(2, 6);
 * 
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. //
 * Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * 
 * // User 1 unfollows user 2. twitter.unfollow(1, 2);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5], // since
 * user 1 is no longer following user 2. twitter.getNewsFeed(1);
 * 
 * @author WANYONGBO
 *
 */
public class Leet355DesignTwitter {
	public static void main(String[] args) {
		Twitter obj = new Twitter();
		obj.postTweet(1, 1);
		obj.postTweet(2, 2);
		obj.follow(1, 2);
		List<Integer> param_2 = obj.getNewsFeed(1);
		obj.unfollow(1, 2);
	}
}

class User {
	public int id;
	public List<User> followed;

	public User(int id) {
		this.id = id;
		this.followed = new ArrayList<User>();
	}

	public static User findUser(List<User> l, int id) {
		for (User u : l) {
			if (id == u.id)
				return u;
		}
		return null;
	}
}

class Tweet {
	public int id;
	public int uid;

	public Tweet(int id, int uid) {
		this.id = id;
		this.uid = uid;
	}

	public static Tweet findTweet(List<Tweet> l, int ids) {
		for (Tweet t : l) {
			if (t.id == ids) {
				return t;
			}
		}
		return null;

	}
}

class Twitter {
	public List<Tweet> twitterList;
	public List<User> userList;

	/** Initialize your data structure here. */
	public Twitter() {
		userList = new ArrayList<User>();
		twitterList = new ArrayList<Tweet>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (User.findUser(userList, userId) == null) {
			userList.add(new User(userId));
		}
		Tweet t = new Tweet(tweetId, userId);
		twitterList.add(t);
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> uidList = new ArrayList<Integer>();
		uidList.add(userId);
		for (User u : User.findUser(userList, userId).followed) {
			if (u != null)
				uidList.add(u.id);
		}
		List<Integer> feedList = new ArrayList<Integer>();
		for (int i = twitterList.size() - 1; i >= 0 && feedList.size() <= 10; i--) {
			Tweet t = twitterList.get(i);
			if (uidList.contains(t.uid)) {
				feedList.add(t.id);
			}
		}
		return feedList;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		User u = User.findUser(userList, followerId);
		if(u==null){
			u=new User(followerId);
			userList.add(u);
		}
		u.followed.add(User.findUser(userList, followeeId));
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		User u = User.findUser(userList, followerId);
		if(u==null){
			u=new User(followerId);
			userList.add(u);
		}
		u.followed.remove(User.findUser(userList, followeeId));
	}
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
