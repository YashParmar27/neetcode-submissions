class Twitter {
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> follows;
    int count;

    public Twitter() {
        tweets = new HashMap<>();
        count = 0;
        follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k-> new ArrayList<>()).add(new int[]{count--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        follows.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for (int followeeId : follows.get(userId))
        {
            if (tweets.containsKey(followeeId))
            {
                List<int []> tweetList = tweets.get(followeeId);
                int index = tweetList.size() - 1;
                int[] tweet = tweetList.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index}); 
            }
        }

        while (!minHeap.isEmpty() && res.size() < 10)
        {
            int[] curr = minHeap.poll();
            res.add(curr[1]);
            int index = curr[3];

            if (index > 0)
            {
                int[] tweet = tweets.get(curr[2]).get(index - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], curr[2], index - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        follows.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v;
        });
    }
}
