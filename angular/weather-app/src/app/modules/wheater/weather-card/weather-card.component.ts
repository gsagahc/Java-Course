import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { faBottleDroplet, faDroplet, faTemperatureHigh, faTemperatureLow, faWind } from '@fortawesome/free-solid-svg-icons';
import { WeatherDatas } from 'src/app/models/interfaces/WeatherDatas';
import { BrowserModule } from '@angular/platform-browser'; 

@Component({
  selector: 'app-weather-card',
  templateUrl: './weather-card.component.html',
  styleUrls: []
})
export class WeatherCardComponent {
@Input() weatherDatasInput!:WeatherDatas;

minTemperatureIcon=faTemperatureLow;
maxTemperatureIcon=faTemperatureHigh;
humidityIcon=faDroplet;
windIcon=faWind;
}
