export interface Product {
  id: number;
  reference: string;
  nom: string;
  description?: string;
  prixUnitaire: number;
  availability: number;
}
