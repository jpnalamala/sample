package com.socialMedia.helper;

import java.util.ArrayList;
import java.util.Map;

public class SocialMediaHelper {

	public static boolean validateUserId(String userId) {
		int userIdLength = userId.length();
		if(userIdLength == 5) {
			Boolean firstLetter = Character.isAlphabetic(userId.charAt(0));
			Boolean remainingString = false;
			for(int i=1;i<userIdLength;i++) {
				 remainingString = Character.isDigit(userId.charAt(i));
				 if(!remainingString) {
					 return false;
				 }
			}
			if(firstLetter && remainingString) {
				return true;
				
			}
		}
		return false;
		
	}
  
	public boolean isUserIdExist(String userId, ArrayList<Map<String, Object>> userList) {
		ArrayList<String> userIds = new ArrayList<String>();
		for (Map<String, Object> entry : userList) {
			for (String key : entry.keySet()) {
				String value = entry.get(key).toString(); 
				if(key.equals("userId")) {
					userIds.add(value);
					break;
				}
			}
		}
		String[] arr = userIds.toArray(new String[userIds.size()]);
		int result = binarySearch(arr, userId);
		if(result == -1) {
			return false;
		}else {
			return true;
		}
	}
	
	static int binarySearch(String[] arr, String x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int res = x.compareTo(arr[m]);
            if (res == 0)
                return m;
  
            if (res > 0)
                l = m + 1;
  
            else
                r = m - 1;
        }
  
        return -1;
    }

	public ArrayList<Map<String, Object>> addFollower(String myUserId, String followeruserId, ArrayList<Map<String, Object>> userList) {
		
		for (Map<String, Object> entry : userList) {
			ArrayList<Object> al = new ArrayList<>();
			if (!entry.containsKey("following") ) {
				entry.put("following", al );
				/*
				 * if(entry.get("following").toString().isEmpty()) { entry.put("following", al
				 * ); }
				 */
			}
			
			for (String key : entry.keySet()) {
				String value = entry.get(key).toString(); 
				
				if(key.equals("userId") && value.equals(myUserId)) {
					//al.removeAll(entry.get("following").toString());
					//al.
					al.add(followeruserId);
					System.out.println("ArrayList");
					System.out.println(al);
					entry.put("following", al );
				}
			}
		}
		
		/*
		 * for (Map<String, Object> entry : userList) { ArrayList al = new
		 * ArrayList<>(); entry.put("following", al ); for (String key : entry.keySet())
		 * { String value = entry.get(key).toString(); if(key.equals("userId") &&
		 * value.equals(myUserId)) {
		 * 
		 * al.add(followeruserId); System.out.println("ArrayList");
		 * System.out.println(al); } } }
		 */
		System.out.println(userList);
		return userList;
	}
}
