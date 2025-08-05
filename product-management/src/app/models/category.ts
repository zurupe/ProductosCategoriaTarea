export interface Category {
  id?: number;
  name: string;
  description: string;
  createdAt?: string; // Usamos string para manejar LocalDateTime en el frontend
}