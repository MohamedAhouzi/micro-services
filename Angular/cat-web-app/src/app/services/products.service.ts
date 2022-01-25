import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product.model';
import {environment} from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class ProductService {
  constructor(private http: HttpClient) {
  }

  public getProducts(): Observable<Product[]> {
    //let host=Math.random()>0.2?environment.host:environment.unreachableHost;
    let host = environment.host;
    return this.http.get<Product[]>(host + '/products');
  }

  public getSelectedProducts(): Observable<Product[]> {
    let host = environment.host;
    return this.http.get<Product[]>(host + '/products?selected=true');
  }

  public getAvailableProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(
      environment.host + '/products?available=true'
    );
  }

  public searchProducts(name: string): Observable<Product[]> {
    return this.http.get<Product[]>(environment.host + "/products?name_like=" + name);
  }

  public setSelected(product: Product): Observable<Product> {
    product.selected = !product.selected;
    return this.http.put<Product>(environment.host + "/products/" + product.id, product);
  }

  public deleteProduct(product: Product): Observable<void> {
    return this.http.delete<void>(environment.host + "/products/" + product.id);
  }

  public save(product: Product): Observable<Product> {
    return this.http.post<Product>(environment.host + "/products/", product);
  }

  public update(product: Product): Observable<Product> {
    return this.http.put<Product>(environment.host + "/products/" + product.id, product);
  }

  public getProductById(id: number): Observable<Product> {
    return this.http.get<Product>(environment.host + "/products/" + id);
  }
}
