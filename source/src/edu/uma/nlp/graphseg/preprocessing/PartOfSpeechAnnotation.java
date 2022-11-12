package edu.uma.nlp.graphseg.preprocessing;

import java.util.Arrays;
import java.util.List;

public class PartOfSpeechAnnotation extends Annotation {
	
    private String tag;

    public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	private String chunkTag;
	
	public String getChunkTag() {
		return chunkTag;
	}

	public void setChunkTag(String chunkTag) {
		this.chunkTag = chunkTag;
	}

	private String coarseTag;
	public String getCoarseTag() {
		if (tag != null) coarseTag = loadCoarsePoSTag();
		return coarseTag;			
	}

    private String loadCoarsePoSTag()
    {
        if (isNoun()) return "N";
        else if (isVerb()) return "V";
        else if (isAdjective()) return "J";
        else if (isAdverb()) return "R";
        else return "O";
    }

    public Boolean isContent()
    {
    	List<String> otherContentPOS = Arrays.asList("CD", "FW", "MD", "SYM", "UH");
        return isNoun() || isVerb() || isAdjective() || isAdverb() || otherContentPOS.contains(tag);
    }
    
    public Boolean isNoun()
    {
        return tag != null && tag.startsWith("N");
    }

    public Boolean isVerb()
    {
        return tag != null && tag.startsWith("V");
    }

    public Boolean isAdjective()
    {
        return tag != null && tag.startsWith("J");
    }

    public Boolean isAdverb()
    {
    	return tag != null && tag.startsWith("RB");
    }
    
}
