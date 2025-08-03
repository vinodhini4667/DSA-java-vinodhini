class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalcolor=image[sr][sc];
        if(originalcolor!=color)
        {
            dfs(image,sr,sc,originalcolor,color);
        }
        return image;
    }

    public void dfs(int[][] image,int i,int j,int originalcolor,int newcolor)
    {
        if(i<0 || j<0 || i>=image.length || j>=image[0].length )
        {
          return;
        }
        if (image[i][j] != originalcolor) 
        {
            return;
        }

        image[i][j]=newcolor;

        dfs(image,i+1,j,originalcolor,newcolor);
        dfs(image,i-1,j,originalcolor,newcolor);
        dfs(image,i,j+1,originalcolor,newcolor);
        dfs(image,i,j-1,originalcolor,newcolor);
    }
}
