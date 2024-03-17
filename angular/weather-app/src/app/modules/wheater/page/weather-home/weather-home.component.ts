import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { Component,OnDestroy, OnInit } from '@angular/core';import { WeatherService } from '../../services/weather.service';
 import { WeatherDatas } from 'src/app/models/interfaces/WeatherDatas';
import {faMagnifyingGlass} from '@fortawesome/free-solid-svg-icons';
import { Subject, takeUntil } from 'rxjs';

@Component({
  selector: 'app-weather-home',
  templateUrl: './weather-home.component.html',
  styleUrls: [],
})
export class WeatherHomeComponent implements OnInit, OnDestroy {
  private readonly destroy$: Subject<void> = new Subject();
  initialCityName = 'Recife';
  weatherDatas!: WeatherDatas;
  searchIcon = faMagnifyingGlass;
  
  constructor(private weatherService: WeatherService) {}

  ngOnInit(): void {
    this.getWheatherDatas(this.initialCityName);
  }
  ngOnDestroy(): void {
    this.destroy$.next;
    this.destroy$.complete;
  }

  getWheatherDatas(cityName: string): void {
    this.weatherService
    .getWeatherDatas(cityName)
    .pipe(takeUntil(this.destroy$))
      .subscribe({
      next: (response) => {
        response && (this.weatherDatas = response);
        console.log(this.weatherDatas)
      },
      error: (error) => console.log(error),
    });
  }
  onSubmit(): void{
	this.getWheatherDatas(this.initialCityName);
	console.log("Cidade : "+this.initialCityName );
	this.initialCityName ='';
	}
}
 
   

