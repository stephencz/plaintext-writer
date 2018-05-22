package com.pte.featurebar;

import java.util.ArrayList;

public class FeatureManager
{

	private final FeatureBar featureBar;
	
	private ArrayList<Feature> features;
	
	public FeatureManager(FeatureBar featureBar)
	{
		this.featureBar = featureBar;
		this.features = new ArrayList<Feature>();
	}

	public ArrayList<Feature> getFeatures()
	{
		return features;
	}

	public void setFeatures(ArrayList<Feature> features)
	{
		this.features = features;
	}

	public FeatureBar getFeatureBar()
	{
		return featureBar;
	}
	
	public Feature getFeature(String name)
	{
		Feature found = null;
		
		for(Feature feature : features)
		{
			if(feature.getName().toUpperCase().trim().equals(name.toUpperCase().trim()))
			{
				found = feature;
			}
		}
		
		return found;
	}
}
