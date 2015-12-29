package eu.shiny.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Trie {

    private TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(String val){
        root.insert(val);
        if(val.length() > 1){
            val = val.substring(1);
            insert(val);
        }
        
    }
    
    public boolean hasWord(String word){
        return root.hasWord(word);
    }
    
    public class TrieNode{
        
        public TrieNode[] cel = new TrieNode[26];
        
        public void insert(String input){
            int charAt =  input.charAt(0) - 97;
            
            if(charAt >= 0 && charAt<= 25 && cel[charAt] == null){
                cel[charAt] = new TrieNode();
            }
            
            if(input.length() > 1){
                cel[charAt].insert(input.substring(1));
            }
        }
        
        public boolean hasWord(String word){
            TrieNode focusNode = this;
            for(int i = 0; i < word.length(); ++i){
                int charAt = word.charAt(i) - 97;
                if(focusNode.cel[charAt] == null){
                    return false;
                }else{
                    focusNode = focusNode.cel[charAt];
                }
            }
            
            return true;
            
        }
        
    }
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        
        Scanner in = new Scanner(System.in);
        
        Integer n = new Integer(in.nextLine());
        
        List<String> facilities = new ArrayList<String>();
        
        
        for(int i = 0; i < n; ++i){
            facilities.add(i, in.nextLine());
        }
        Collections.sort(facilities);
        
        StringBuffer desc = new StringBuffer();
        desc.append(in.nextLine());
        
        String[] words = desc.toString().split(" ");
        for(String word : words){
            if(!word.equalsIgnoreCase(""))
            trie.insert(word.toLowerCase().replaceAll("[,.-_]", ""));
        }
        
        for(String facility: facilities){
            String[] tokens = facility.split(" ");
            boolean found = true;
            for(String token : tokens){
                if(!trie.hasWord(token.toLowerCase())){
                    found = false;
                    break;
               }
            }
            if(found){
                System.out.println(facility);
            }
        }
        
    }
}
