package com.socialMedia.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.socialMedia.helper.SocialMediaHelper;

public class SocialMedia {
	 
	public static void main(String[] args) {
		SocialMediaHelper helper = new SocialMediaHelper();
		System.out.println("1. Add a user in the network\r\n" + "2. Follow a user\r\n" + "3. Find all the followers of a user\r\n" + "4. Find all the followings of a user\r\n" +"5. Remove a following of a user\r\n" +
				"6. Remove a user from the network\r\n" + "7. Exit");
		Scanner in = new Scanner(System.in);  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int menu = in.nextInt();
		ArrayList<Map<String, Object>> userList = new ArrayList<Map<String,Object>>();
		ArrayList<Map<String, Object>> updatedUserList = new ArrayList<Map<String,Object>>();
		String userName = "";
		String userId = "";
		if(menu == 1) {
			while(menu<7) {
				switch(menu){
				case 1 :
				{
					
					try {
						System.out.println("Please enter User Name : ");
						userName = br.readLine();
						System.out.println("Please enter UserId :");
						userId =  br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					boolean validUserId = helper.validateUserId(userId); // exists true
					boolean isUserIdExist = false;
					if(!userList.isEmpty()) {
						isUserIdExist = helper.isUserIdExist(userId,userList);
					}
					if(!validUserId || isUserIdExist) {
						System.out.println("Please enter Valid UserId");
						break;
					}else {
						HashMap<String, Object> user = new HashMap<String, Object>();
						System.out.println("Valid User");
						user.put("userName", userName);
						user.put("userId", userId);
						userList.add(user);
						System.out.println("Do you want another user ? Please press 1");
						break;
					}
					
					
					}
				case 2 :
				
					
					try {
						System.out.println("Enter your Id");
						String myUserId = br.readLine();
						if(helper.isUserIdExist(myUserId,userList)) {
							System.out.println("Enter userId to follow");
							String FolloweruserId =  br.readLine();
							if(helper.isUserIdExist(FolloweruserId,userList)) {
								
								updatedUserList = helper.addFollower(myUserId,FolloweruserId,userList);
								break;
							}else {
								System.out.println("Please enter follower UserId");
							}
						}else {
							System.out.println("Please enter your UserId");
						}

					} catch (IOException e) {
						e.printStackTrace();
					}
					
				
				
				}
				if(!updatedUserList.isEmpty()) {
					userList = updatedUserList;
				}
				
				 menu = in.nextInt();
				System.out.println(userList);
			}
		}
	}

	

}