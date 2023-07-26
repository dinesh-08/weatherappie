//package com.bwap.weatherapp.WeatherApp.Repository;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.bwap.weatherapp.WeatherApp.model.WeatherDetails;
//
//public abstract class WeatherDetailsRepository implements JpaRepository<WeatherDetails,Integer>
//{
//  
//}
package com.bwap.weatherapp.WeatherApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bwap.weatherapp.WeatherApp.model.WeatherDetails;

public interface WeatherDetailsRepository extends JpaRepository<WeatherDetails, Integer> {
    // Add custom query methods here if needed
}

