/**
 * Problem: Design Twitter
 * Platform: LeetCode
 *
 * Approach (Hash Table):
 * 1. Use a hash table to store the user's tweets.
 * 2. Use a hash table to store the user's followees.
 * 3. Use a method to post a tweet.
 * 4. Use a method to get the news feed.
 * 5. Use a method to follow a user.
 * 6. Use a method to unfollow a user.
 */
/**
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a hash table to store the user's tweets.
 * 2. We use a hash table to store the user's followees.
 * 3. We use a method to post a tweet.
 * 4. We use a method to get the news feed.
 * 5. We use a method to follow a user.
 * 6. We use a method to unfollow a user.
 */
class Twitter {
    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;

    // Helper class to store tweet metadata
    private class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        // Increment global timestamp so we know which tweet came first
        tweetMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // 1. Add user's own tweets
        if (tweetMap.containsKey(userId)) {
            List<Tweet> userTweets = tweetMap.get(userId);
            // Optimization: only need the last 10 from any single user
            int start = Math.max(0, userTweets.size() - 10);
            for (int i = start; i < userTweets.size(); i++) {
                maxHeap.add(userTweets.get(i));
            }
        }

        // 2. Add tweets from followees
        if (followMap.containsKey(userId)) {
            for (int followeeId : followMap.get(userId)) {
                if (tweetMap.containsKey(followeeId)) {
                    List<Tweet> fTweets = tweetMap.get(followeeId);
                    int start = Math.max(0, fTweets.size() - 10);
                    for (int i = start; i < fTweets.size(); i++) {
                        maxHeap.add(fTweets.get(i));
                    }
                }
            }
        }

        // 3. Extract top 10
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            res.add(maxHeap.poll().id);
            count++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId) || followerId == followeeId) return;
        followMap.get(followerId).remove(followeeId);
    }
}
